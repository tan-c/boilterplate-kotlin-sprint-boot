## DB Migration

FlywayDB is used to manage DB migration. https://flywaydb.org/ and https://flywaydb.org/documentation/maven/

The current schema is set as baseline with `mvn flyway:baseline`and the schema is saved under resources/db.migration/V1__Base_version.sql 
 
 
| Command | Usage |
|---------|-------|
| `mvn flyway:info` | Check Flyway Migration History |
| `mvn flyway:migrate` | Check Flyway Migration History |
| `mvn flyway:clean` | Check Flyway Migration History |

Note that you will need to pass in environment variables as CLI params, e.g. 
mvn -Dflyway.url='jdbc:sqlserver://localhost:32768;database=uat-stey-01' -Dflyway.user=sa -Dflyway.password=my_password flyway:info
 
### Add New Migration File
1. Create a new migration file in resource/db/migration. It has to start with a version number followed bu double underscore. e.g. V1.1_Add_uid_to_banner_table
2. Run `mvn flyway:info` to verify current state and `mvn flyway:validate` to ensure that validation can work
3. Run `mvn flyway:migrate` to migrate the DB, or just `make migrate` 
