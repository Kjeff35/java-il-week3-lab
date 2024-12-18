# MICROSERVICE ECOMMERCE APPLICATION
An e-commerce application with separate microservices for
user management, product catalog, and order processing.

## TECHNOLOGY
- Spring Boot: Backend server for handling requests
- Keycloak: For user management, authentication and authorization
- Postgres: NoSQL database for backend data.

## USAGE
1. Create a docker network
```
docker network create lab-network
```
2. Start your postgres database and keycloak server
```
docker-compose -f docker-compose-keycloak.yml up --build -d
```
3. Configure keycloak by following this [guide](KEYCLOAK.md)
4. Create a .env file in the root folder
```
DB_HOST=host.docker.internal
EUREKA_HOST=discovery-server
CONFIG_SERVER_HOST_NAME=config-server
GATEWAY_HOST_NAME=gateway-server
PRODUCT_SERVICE_HOST_NAME=product-service
ORDER_SERVICE_HOST_NAME=order-service
KEYCLOAK_HOST=keycloak

PRODUCT_DB_URL=jdbc:postgresql://${DB_HOST}:5432/product
ORDER_DB_URL=jdbc:postgresql://${DB_HOST}:5432/order
DB_USERNAME=your_db_username
DB_PASSWORD=your_db_password

GOOGLE_ID=your_google_id
GOOGLE_SECRET=your_google_secret
GITHUB_ID=your_github_id
GITHUB_SECRET=your_github_secret

CLIENT_ID=your_client_id
CLIENT_SECRET=your_client_secret

# Get ISSUER_URI and JWK_SET_URI from http://localhost:8080/realms/{your-realm-name}/.well-known/openid-configuration
EUREKA_DEFAULT_URI=http://${EUREKA_HOST}:8761/eureka
CONFIG_SERVER_URL=http://${CONFIG_SERVER_HOST_NAME}:8888
ISSUER_URI=your_issuer_uri
JWK_SET_URI=your_jwk_set_uri
```
5. Run the microservice
```
docker-compose -f docker-compose.yml up --build -d
```