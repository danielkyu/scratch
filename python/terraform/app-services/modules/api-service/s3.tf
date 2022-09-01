module "label_s3_test" {
  source = "cloudposse/label/null"
  version = "0.25.0"
  name = var.label_base
  attributes = ["test-bucket"]
}

resource "aws_s3_bucket" "s3_test" {
  bucket = module.label_s3_test.id
}
