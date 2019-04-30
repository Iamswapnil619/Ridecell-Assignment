# Ridecell-Assignment
This Repository contains the assignment code for spark streaming.

It includes the src code and pom file.

This code will work in local mode as is but if you want to run this code on spark cluster than you need to change spark session master to yarn.

Set the input path as per local or hdfs path.

Command to run this code on cluser : 

spark-submit --class com.ridecell.driver.configurator <folder path to jar >/ridecell-project-0.0.1-SNAPSHOT-jar-with-dependencies.jar

Output : 

1. Getway service 1 minute window :   
+------------------------------------------------------------+------------------------------------------+---------------+
|GETWAY-SERVICE                                              |window                                    |aggregate_count|
+------------------------------------------------------------+------------------------------------------+---------------+
|/api-gateway/v3/customers/                                  |[2018-03-12 17:26:00, 2018-03-12 17:27:00]|2              |
|/api-gateway/v3/vehicle_types/                              |[2018-03-12 17:29:00, 2018-03-12 17:30:00]|2              |
|/api-gateway/v3/services/settings/                          |[2018-03-12 17:29:00, 2018-03-12 17:30:00]|2              |
|/api-gateway/v3/vehicles/3012                               |[2018-03-12 17:29:00, 2018-03-12 17:30:00]|2              |
|/api-gateway/v3/customers/                                  |[2018-03-12 17:29:00, 2018-03-12 17:30:00]|2              |
|/api-gateway/v2/logs                                        |[2018-03-12 17:26:00, 2018-03-12 17:27:00]|66             |
|/api-gateway/v2/token-refresh/                              |[2018-03-12 17:29:00, 2018-03-12 17:30:00]|2              |
|/api-gateway/v3/vehicle_types/                              |[2018-03-12 17:26:00, 2018-03-12 17:27:00]|2              |
|/api-gateway/v3/rentals/pricing_info/                       |[2018-03-12 17:26:00, 2018-03-12 17:27:00]|2              |
|/api-gateway/v3/rentals/pricing_info/                       |[2018-03-12 17:29:00, 2018-03-12 17:30:00]|2              |
|/api-gateway/v2/otakeys_bluetooth/authenticate_device_token/|[2018-03-12 17:26:00, 2018-03-12 17:27:00]|2              |
|/api-gateway/v3/vehicles/3084                               |[2018-03-12 17:26:00, 2018-03-12 17:27:00]|2              |
|/api-gateway/v3/services/geofences                          |[2018-03-12 17:29:00, 2018-03-12 17:30:00]|2              |
|/api-gateway/v2/settings/                                   |[2018-03-12 17:29:00, 2018-03-12 17:30:00]|2              |
|/api-gateway/v3/services/service_regions/                   |[2018-03-12 17:29:00, 2018-03-12 17:30:00]|2              |
|/api-gateway/v3/services                                    |[2018-03-12 17:29:00, 2018-03-12 17:30:00]|2              |
|/api-gateway/v3/vehicles/3012                               |[2018-03-12 17:26:00, 2018-03-12 17:27:00]|10             |
|/api-gateway/v3/accounts/actions/token_renew/               |[2018-03-12 17:29:00, 2018-03-12 17:30:00]|2              |
|/api-gateway/v3/services/damage_locations                   |[2018-03-12 17:29:00, 2018-03-12 17:30:00]|2              |
|/api-gateway/v2/appreleases/                                |[2018-03-12 17:29:00, 2018-03-12 17:30:00]|2              |
+------------------------------------------------------------+------------------------------------------+---------------+

2. Getway service 5 minute window :
 
+------------------------------------------------------------+------------------------------------------+---------------+
|GETWAY-SERVICE                                              |window                                    |aggregate_count|
+------------------------------------------------------------+------------------------------------------+---------------+
|/api-gateway/v3/services/settings/                          |[2018-03-12 17:25:00, 2018-03-12 17:30:00]|2              |
|/api-gateway/v3/rentals/pricing_info/                       |[2018-03-12 17:25:00, 2018-03-12 17:30:00]|4              |
|/api-gateway/v2/appreleases/                                |[2018-03-12 17:25:00, 2018-03-12 17:30:00]|2              |
|/api-gateway/v2/token-refresh/                              |[2018-03-12 17:25:00, 2018-03-12 17:30:00]|2              |
|/api-gateway/v3/services/service_regions/                   |[2018-03-12 17:25:00, 2018-03-12 17:30:00]|2              |
|/api-gateway/v3/services/geofences                          |[2018-03-12 17:25:00, 2018-03-12 17:30:00]|2              |
|/api-gateway/v2/logs                                        |[2018-03-12 17:25:00, 2018-03-12 17:30:00]|120            |
|/api-gateway/v3/accounts/actions/token_renew/               |[2018-03-12 17:25:00, 2018-03-12 17:30:00]|2              |
|/api-gateway/v3/vehicles/3084                               |[2018-03-12 17:25:00, 2018-03-12 17:30:00]|2              |
|/api-gateway/v3/vehicle_types/                              |[2018-03-12 17:25:00, 2018-03-12 17:30:00]|4              |
|/api-gateway/v3/vehicles/3012                               |[2018-03-12 17:25:00, 2018-03-12 17:30:00]|12             |
|/api-gateway/v3/services/damage_types                       |[2018-03-12 17:25:00, 2018-03-12 17:30:00]|2              |
|/api-gateway/v3/services/damage_locations                   |[2018-03-12 17:25:00, 2018-03-12 17:30:00]|2              |
|/api-gateway/v2/otakeys_bluetooth/authenticate_device_token/|[2018-03-12 17:25:00, 2018-03-12 17:30:00]|4              |
|/api-gateway/v3/services                                    |[2018-03-12 17:25:00, 2018-03-12 17:30:00]|2              |
|/api-gateway/v2/settings/                                   |[2018-03-12 17:25:00, 2018-03-12 17:30:00]|2              |
|/api-gateway/v3/customers/                                  |[2018-03-12 17:25:00, 2018-03-12 17:30:00]|4              |
+------------------------------------------------------------+------------------------------------------+---------------+

3. http-methods-1minute-window : 

+------------+------------------------------------------+---------------+
|HTTP-METHODS|window                                    |aggregate_count|
+------------+------------------------------------------+---------------+
|GA.POST     |[2018-03-12 17:29:00, 2018-03-12 17:30:00]|60             |
|GA.GET      |[2018-03-12 17:29:00, 2018-03-12 17:30:00]|24             |
|GA.POST     |[2018-03-12 17:26:00, 2018-03-12 17:27:00]|68             |
|GA.GET      |[2018-03-12 17:26:00, 2018-03-12 17:27:00]|18             |
+------------+------------------------------------------+---------------+

4. http-methods-5minute-window : 

+------------+------------------------------------------+---------------+
|HTTP-METHODS|window                                    |aggregate_count|
+------------+------------------------------------------+---------------+
|GA.POST     |[2018-03-12 17:25:00, 2018-03-12 17:30:00]|128            |
|GA.GET      |[2018-03-12 17:25:00, 2018-03-12 17:30:00]|42             |
+------------+------------------------------------------+---------------+
