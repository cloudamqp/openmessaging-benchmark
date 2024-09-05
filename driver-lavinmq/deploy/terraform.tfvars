public_key_path = "~/.ssh/lavinmq_aws.pub"
region          = "us-west-2"
az              = "us-west-2a"
ami             = "ami-08970fb2e5767e3b8" // RHEL-8

instance_types = {
  "lavinmq"   = "i3en.6xlarge"
  "client"     = "m5n.8xlarge"
  "prometheus" = "t2.large"
}

num_instances = {
  "lavinmq"   = 1
  "client"     = 4
  "prometheus" = 1
}
