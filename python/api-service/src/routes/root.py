import boto3
import json
import logging

from dependency_injector.wiring import inject, Provide
from fastapi import APIRouter, Depends, Request

from src.container import Container
from src.routes.schemas.root import EchoRequest, EchoResponse

logger = logging.getLogger(__name__)
router = APIRouter()


@router.get("/")
def helloWorld(request: Request):
    print(request.client.host)
    return "Hello world!!"


@router.get("/env")
@inject
def getEnv(config: dict = Depends(Provide[Container.config])):
    logger.info("This is a test message.")
    return config["env"]


@router.post("/echo", response_model=EchoResponse)
def echo(request: EchoRequest):
    return EchoResponse(message=request.message)


@router.get("/lambda")
@inject
def invokeLambda(awsLambda: boto3.client = Depends(Provide[Container.awsLambda])):

    response = awsLambda.invoke(
        FunctionName="test",
        Payload=json.dumps({})
    )

    print(response["Payload"])

    return response["Payload"].read().decode("utf-8")
