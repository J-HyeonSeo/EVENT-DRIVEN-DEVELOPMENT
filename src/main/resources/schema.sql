CREATE TABLE event."order" (
                               order_id BIGSERIAL PRIMARY KEY,
                               item_name VARCHAR(255),
                               price BIGINT CHECK (price >= 0) -- 양의 정수로 가격 제한
);

CREATE TABLE event."payment" (
                               payment_id BIGSERIAL PRIMARY KEY,
                               order_id BIGINT,
                               price BIGINT CHECK (price >= 0), -- 양의 정수로 가격 제한
                               FOREIGN KEY (order_id) REFERENCES event."order"(order_id)
);