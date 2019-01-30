default:  flywaydb

# Run flyway db migration
ktlint:
	ktlint --apply-to-idea-project

flywaydb:
	mvn -Dflyway.url='jdbc:h2:file:~/dasboot' -Dflyway.user=sa -Dflyway.password= flyway:info

migrate:
	mvn -Dflyway.url='jdbc:h2:file:~/dasboot' -Dflyway.user=sa -Dflyway.password= flyway:migrate

clean:
	mvn -Dflyway.url='jdbc:h2:file:~/dasboot' -Dflyway.user=sa -Dflyway.password= flyway:clean
