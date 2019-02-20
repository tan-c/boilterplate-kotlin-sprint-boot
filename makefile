default:  flywaydb

# Alternatively you can run make:migrate with specified H2_DIR
# H2_DIR=integration make:migrate
H2_DIR ?= 'localhost'

# Run flyway db migration
ktlint:
	ktlint --apply-to-idea-project

info:
	gradle flywayMigrate -i
	# mvn -Dflyway.url='jdbc:h2:file:~/$(H2_DIR)' -Dflyway.user=sa -Dflyway.password= flyway:info

migrate:
	mvn -Dflyway.url='jdbc:h2:file:~/$(H2_DIR)' -Dflyway.user=sa -Dflyway.password= flyway:migrate

clean:
	mvn -Dflyway.url='jdbc:h2:file:~/$(H2_DIR)' -Dflyway.user=sa -Dflyway.password= flyway:clean

integration-test:
	mvn -Dtest=*IT --activate-profiles=integration test
