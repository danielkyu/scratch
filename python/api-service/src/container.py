import boto3.session

from dependency_injector import containers, providers


class Container(containers.DeclarativeContainer):
    config = providers.Configuration()

    aws = providers.Resource(
        boto3.session.Session,
        aws_access_key_id=config.aws.access_key_id,
        aws_secret_access_key=config.aws.secret_access_key,
        region_name=config.aws.region
    )

    awsLambda = providers.Resource(
        aws.provided.client.call(),
        endpoint_url=config.aws.endpoint_url,
        service_name="lambda"
    )

    wiring_config = containers.WiringConfiguration(packages=[
        # Register packages that utilize DI here.
        ".routes",
    ])
