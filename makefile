default:  flywaydb

# Alternatively you can run make:migrate with specified H2_DIR
# H2_DIR=integration make:migrate
H2_DIR ?= 'localhost'

# Run flyway db migration
ktlint:
	ktlint --apply-to-idea-project

# Details in here
# https://flywaydb.org/documentation/gradle/
info:
	gradle flywayInfo -i
	# mvn -Dflyway.url='jdbc:h2:file:~/$(H2_DIR)' -Dflyway.user=sa -Dflyway.password= flyway:info

migrate:
	gradle flywayValidate -i
	gradle flywayMigrate -i
	# mvn -Dflyway.url='jdbc:h2:file:~/$(H2_DIR)' -Dflyway.user=sa -Dflyway.password= flyway:migrate

clean:
	gradle flywayClean -i
	# mvn -Dflyway.url='jdbc:h2:file:~/$(H2_DIR)' -Dflyway.user=sa -Dflyway.password= flyway:clean

repair:
	gradle flywayRepair -i

integration-test:
	mvn -Dtest=*IT --activate-profiles=integration test
