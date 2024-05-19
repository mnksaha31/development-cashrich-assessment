CREATE TABLE IF NOT EXISTS user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(100) UNIQUE,
    mobile VARCHAR(15),
    username VARCHAR(15) UNIQUE,
    password VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS api_request_response (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    user_id BIGINT,
    request TEXT,
    response TEXT,
    timestamp TIMESTAMP,
    FOREIGN KEY (user_id) REFERENCES user(id)
);
