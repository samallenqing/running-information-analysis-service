# Running Information Analysis Service

This is the first assignment from CS504

## Step1 - Create a directory folder and download files from github

Use the following cmd in terminal to create the requests files. Here use examples "test".
```
mkdir test
cd test
git clone https://github.com/samallenqing/running-information-analysis-service.git

```

### Step2 - Use Docker to build images

Use the terminal before to enter the following cmd.

```
cd running-information-analysis-service/
docker-compose up
```

### Step3 - Run MySql

If you have installed MySql open a new terminal run the following cmd. Because I changed the default password to 1, so "--password=1". Please be sure to update the password to your MySql password.

```
 mysql --host=127.0.0.1 --port=3306 --user=root --password=1
```
Now we need create a new table for the service to store datas. Here use the file name "running_information_analysis_service_db". Use the same terminal above enter the following ```

```
create database running_information_analysis_service_db;
```
## Step4 - Running Project

open a new terminal and directory to the project path and enter the following cmd.

```
mvn clean install
cd target
java -jar running-information-analysis-service-1.0.0.BUILD-SNAPSHOT.jar 
```

## Step5 - Running testCase.json by Postman

Open file "testCase.json" copy and paste all the datas to Postman body part and choose file type Json.

| Rest URL|  Http Method     | Description     |
| :------------- | :------------- | :------------- | 
| /run       | POST       | Upload raw Json data to database       | 
| /view       | GET       | Fetch information. The default show 2 results in every page. It can be modified by adding size or page parameter. Eg:/view?size=10       |
| /delete/{runningId}       | DELETE       | Delete the running information by runningId       |

### Step6 - Check data from MySql

From time to time we modified the datas, we can use MySql terminal to read datas. By default, the table has been created by application called "Running_Analysis"(Homework requirement). For a instance, we can use the following cmd to fetch all the data where username = ross0.(If this information have not yet been deleted by operator.)

```
select * from Running_Analysis where username = 'ross0';
 
```

## Built With

* [Dropwizard](http://www.dropwizard.io/1.0.2/docs/) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [ROME](https://rometools.github.io/rome/) - Used to generate RSS Feeds

## Authors

* **Sam Qing** - *Initial work* - [Sam](https://github.com/samallenqing)

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
