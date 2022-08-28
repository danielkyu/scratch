FROM public.ecr.aws/lambda/python:3.9

COPY . ${LAMBDA_TASK_ROOT}
WORKDIR ${LAMBDA_TASK_ROOT}

RUN pip install pipenv
RUN pipenv install --ignore-pipfile

CMD ["src.lambda.lambda.lambda_handler"]
