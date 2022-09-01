provider "aws" {
  region = var.aws_region
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