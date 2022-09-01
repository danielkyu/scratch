variable "aws_profile" {
  description = "The AWS profile that should be used to fetch AWS credentials."
  type = string
}

variable "aws_region" {
  description = "The AWS region that resources will be provisioned in."
  type = string
}

variable "environment" {
  description = "The name of the deployment environment the resources are associated with."
  type = string
}