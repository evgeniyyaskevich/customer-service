CUSTOMER_API = localhost:8080/customer-service
DATA_SAMPLE_PATH=./data

mvn-build:
	mvn clean package

start: mvn-build
	mvn spring-boot:run

health-check:
	curl -v ${CUSTOMER_API}/v1/customer

create:
	curl -v \
	-H "Content-type: application/json" \
	--data @${DATA_SAMPLE_PATH}/customer.json \
	${CUSTOMER_API}/v1/customer

find-by-id:
	read -p "Customer id: " customerId; \
	curl -v \
	${CUSTOMER_API}/v1/customer/$$(echo $$customerId)

delete-by-id:
	read -p "Customer id: " customerId; \
	curl -v \
	-X DELETE \
	${CUSTOMER_API}/v1/customer/$$(echo $$customerId)

find:
	curl -v \
	'${CUSTOMER_API}/v1/customer?page=1&size=50'