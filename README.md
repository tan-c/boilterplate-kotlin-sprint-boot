# Kotlin + Spring Boot Boilterplate
This is a boilerpalte code for Kotlin + Spring Boot + Gradle for a basic API server

Features including
- Spring CRUD with base controller
- Sample unit/integration/api tests
- Spring Security
- detekt integration
- semantic-release

## Spring Security


## DB Migration

FlywayDB is used to manage DB migration. https://flywaydb.org/ and https://flywaydb.org/documentation/maven/

The current schema is set as baseline with `mvn flyway:baseline`and the schema is saved under resources/db.migration/V1__Base_version.sql 
 
 
| Command | Usage |
|---------|-------|
| `mvn flyway:info` | Check Flyway Migration History |
| `mvn flyway:migrate` | Check Flyway Migration History |
| `mvn flyway:clean` | Check Flyway Migration History |

### Add New Migration File
1. Create a new migration file in resource/db/migration. It has to start with a version number followed bu double underscore. e.g. V1.1_Add_uid_to_banner_table
2. Run `mvn flyway:info` to verify current state and `mvn flyway:validate` to ensure that validation can work
3. Run `mvn flyway:migrate` to migrate the DB, or just `make migrate` 

## Release Pipeline
semantic-release is integrated for release management 
