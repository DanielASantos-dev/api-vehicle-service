CREATE TABLE Vehicles(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    vehicleName VARCHAR(50) NOT NULL,
    brand VARCHAR(30) NOT NULL,
    yearVehicle INT NOT NULL,
    description TEXT,
    urlImg VARCHAR(255),
    isSold BOOL,
    createdAt DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updatedAt DATETIME
)