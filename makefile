default:  flywaydb

# Lint the terraform files. Don't forget to provide the 'region' var, as it is
# not provided by default. Error on issues, suitable for CI.
# lint:
#	terraform get
#	TF_VAR_region="ap-northeast-1" tflint --error-with-issues


# Run flyway db migration
flywaydb:
	echo 1
#	circleci config validate -c .circleci/config.yml
# 	circleci build --job lint