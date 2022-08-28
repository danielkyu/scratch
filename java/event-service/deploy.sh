#! /bin/bash

./gradlew build

if [[ $? -ne 0 ]]; then
  exit $?
fi

awslocal lambda delete-function --function-name event-service_hello-world

awslocal stepfunctions delete-state-machine \
  --state-machine-arn arn:aws:states:us-east-1:000000000000:stateMachine:root

awslocal lambda create-function --role dummy-role \
  --runtime java11 \
  --zip-file fileb://build/distributions/event-service.zip \
  --timeout 10 \
  --function-name event-service_hello-world \
  --handler com.danielkyu.templates.eventservice.handlers.HelloWorldRequestHandler

awslocal stepfunctions create-state-machine \
  --role-arn "arn:aws:iam::000000000000:role/dummy-role" \
  --definition file://state-machines/root.json \
  --name root

awslocal stepfunctions start-execution \
  --state-machine "arn:aws:states:us-east-1:000000000000:stateMachine:root" \
  --name test \
  --input '{"key": "value"}'

# awslocal stepfunctions describe-execution \
#   --execution-arn "arn:aws:states:us-east-1:000000000000:execution:root:test"

# awslocal lambda invoke --cli-binary-format raw-in-base64-out \
#   --function-name event-service_hello-world \
#   --payload '{ "key": "value" }' \
#  out.txt
