provider "aws" {
  profile = var.aws_profile
  region = var.aws_region

  skip_credentials_validation = true
  skip_requesting_account_id = true

  endpoints {
    lambda = "http://localhost:4566"
    s3 = "http://s3.localhost.localstack.cloud:4566"
  }
}

module "label_base" {
  source = "cloudposse/label/null"
  version = "0.25.0"
  namespace = "ps"
  stage = var.environment
}

module "label_api_service" {
  source = "cloudposse/label/null"
  version = "0.25.0"
  context = module.label_base.context
  attributes = ["api-service"]
}

module "api_service" {
  source = "../../modules/api-service"
  label_base = module.label_api_service.id
}