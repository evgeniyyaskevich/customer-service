## customer-service

Web service is responsible for storing and modification of  customer entity.
It provides the customer API to perform different operations on customer entity.

## Getting Started

The service is a quite simple spring boot application. It stores the customer data and provides the API
to work with customer entities.

The service stores the data in embedded MongoDB. So, no need in any external dependencies for now.

Please see the _Road Map_ section for further development plans.

### Prerequisites

* Java 11+
* [Maven](https://maven.apache.org/)
* [curl](https://curl.se/)
* [Make](https://makefiletutorial.com/)

### Installation & Usage

Run to start the application: `make start`

Run to create a sample customer: `make create`

Run to retrieve a customer by id: `make find-by-id`

Run to delete a customer by id: `make delete-by-id`

Please also review the `Makefile` to find other useful commands for local development and testing.

## Roadmap


- [x] Setup spring boot application with health check
- [x] Implement GET customer
    - [x] Connect service to datastore
    - [x] Setup controller for customer GET
- [x] Implement CREATE customer
  - [x] Define the customer model
  - [x] Setup backend validation
  - [x] Setup a creation endpoint
- [ ] Implement LIST customer
  - [ ] Define the search criteria & paging model
  - [ ] Setup LIST endpoint
- [x] Implement DELETE customer endpoint
- [ ] Ensure unit & integration tests exists
- [ ] Update README file
  - [x] Run service locally
  - [ ] Scaling (up & out)
  - [x] Test scripts
- [ ] Setup Dockerfile with MongoDB dependency for the service.

## Maintainers

Yauheni Yaskevich - evgeniy.yaskevich@yandex.by