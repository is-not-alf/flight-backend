CREATE TABLE airports (
  id BIGSERIAL PRIMARY KEY,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

  name VARCHAR(255) NOT NULL,
  code VARCHAR(255) NOT NULL,
  city VARCHAR(255) NOT NULL
);
CREATE UNIQUE INDEX idx_airports_code ON airports(code); 

CREATE TABLE aircrafts (
  id BIGSERIAL PRIMARY KEY,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

  model VARCHAR(255) NOT NULL,
  capacity INT NOT NULL
);

CREATE TABLE flights (
  id BIGSERIAL PRIMARY KEY,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

  arrival_time TIMESTAMP NOT NULL,
  departure_time TIMESTAMP NOT NULL,
  flight_number VARCHAR(255) NOT NULL,

  arrival_airport_id BIGINT REFERENCES airports(id) NOT NULL,
  departure_airport_id BIGINT REFERENCES airports(id) NOT NULL,
  aircraft_id BIGINT REFERENCES aircrafts(id) NOT NULL
);
CREATE INDEX idx_flights_departure_airport ON flights(departure_airport_id);
CREATE INDEX idx_flights_arrival_airport ON flights(arrival_airport_id);
CREATE INDEX idx_flights_departure_time ON flights(departure_time);

CREATE TABLE passengers (
  id BIGSERIAL PRIMARY KEY,
  created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

  first_name VARCHAR(255) NOT NULL,
  last_name VARCHAR(255) NOT NULL,
  passport_number VARCHAR(255) NOT NULL,

  flight_id BIGINT REFERENCES flights(id)
);
CREATE INDEX idx_passengers_flight_id ON passengers(flight_id);

INSERT INTO airports (name, code, city) VALUES
('Шереметьево', 'SVO', 'Москва'),
('Пулково', 'LED', 'Санкт-Петербург'),
('Кольцово', 'SVX', 'Екатеринбург'),
('Толмачево', 'OVB', 'Новосибирск'),
('Адлер', 'AER', 'Сочи');

INSERT INTO aircrafts (model, capacity) VALUES
('Sukhoi Superjet 100', 100),
('Airbus A320', 180),
('Boeing 737-800', 189);

INSERT INTO flights (departure_time, arrival_time, flight_number, departure_airport_id, arrival_airport_id, aircraft_id) VALUES
('2026-09-01 10:00:00', '2026-09-01 11:30:00', 'SU-010', 1, 2, 1),
('2026-09-01 13:00:00', '2026-09-01 14:30:00', 'SU-011', 2, 1, 1),
('2026-09-02 08:00:00', '2026-09-02 11:45:00', 'SU-1122', 1, 5, 2),
('2026-09-02 13:00:00', '2026-09-02 16:45:00', 'SU-1123', 5, 1, 2),
('2026-09-03 01:00:00', '2026-09-03 03:20:00', 'DP-405', 1, 3, 3),
('2026-09-03 05:00:00', '2026-09-03 07:15:00', 'S7-5022', 3, 4, 1),
('2026-09-04 12:00:00', '2026-09-04 16:30:00', 'S7-3015', 4, 2, 2),
('2026-09-04 18:00:00', '2026-09-04 22:15:00', 'DP-512', 2, 5, 3),
('2026-09-05 09:00:00', '2026-09-05 14:30:00', 'U6-224', 5, 3, 2),
('2026-09-05 16:00:00', '2026-09-05 18:20:00', 'U6-261', 3, 1, 3);

INSERT INTO passengers (first_name, last_name, passport_number, flight_id) VALUES
('Иван', 'Иванов', '4508-111222', 1),
('Мария', 'Петрова', '4512-333444', 1),

('Алексей', 'Смирнов', '4015-555666', 2),
('Ольга', 'Кузнецова', '4019-777888', 2),

('Дмитрий', 'Попов', '4610-999000', 3),
('Елена', 'Васильева', '4614-123456', 3),
('Артем', 'Соколов', '4505-654321', 3),

('Николай', 'Михайлов', '4510-987654', 4),
('Анна', 'Новикова', '4516-456789', 4),

('Сергей', 'Федоров', '6511-112233', 5),
('Татьяна', 'Морозова', '6515-445566', 5),

('Михаил', 'Волков', '5012-778899', 6),
('Наталья', 'Алексеева', '5016-001122', 6),
('Игорь', 'Лебедев', '5020-334455', 6),

('Александр', 'Семенов', '3214-556677', 7),
('Юлия', 'Егорова', '3218-889900', 7),

('Андрей', 'Павлов', '4011-115599', 8),
('Светлана', 'Козлова', '4016-226600', 8),
('Денис', 'Степанов', '4022-337711', 8),

('Владимир', 'Николаев', '0315-448822', 9),
('Екатерина', 'Орлова', '0319-559933', 9),

('Максим', 'Макаров', '6509-660044', 10),
('Евгения', 'Захарова', '6514-771155', 10),
('Анатолий', 'Зайцев', '6518-882266', 10);