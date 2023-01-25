insert into screening_result (operator, tp_doc, shipment_number, booked_by_customer_code, booked_by_customer_name,
                              shipper_customer_code, shipper_customer_name, shipper_address_line1, shipper_address_line2,
                              consignee_customer_code, consignee_customer_name, consignee_address_line1, first_notify_customer_code,
                              first_notify_customer_name, first_notify_address_line1, second_notify_customer_code, second_notify_customer_name,
                              second_notify_address_line1, commodity_code, commodity_description, cargo_documentation_description,
                              contractual_customer_customer_code, contractual_customer_customer_name, haz, por_country_name, pod_country_name)
values ('Operator 1', 1233413, 34525234, 6524552, 'Customer Name 1', 14151123, 'Shipper Name 1', 'Bul Mil Mil 9dj', 'Bul Zor Djin 128',
        8921934, 'Consignee Name 1', 'Bul Kr Aleks 19', 7183812, 'Notify Name 1', 'Bul Oslob 92', 8143712, 'Second notify name 1',
        'Bul rev 1', '321412', '21 WC QU 18992', 'WLE 87831 SPOPS', 32114124, 'Con Cust Name 1', 'HA1', 'Serbia', 'Montenegro');

insert into screening_result (operator, tp_doc, shipment_number, booked_by_customer_code, booked_by_customer_name,
                              shipper_customer_code, shipper_customer_name, shipper_address_line1, shipper_address_line2,
                              consignee_customer_code, consignee_customer_name, consignee_address_line1, first_notify_customer_code,
                              first_notify_customer_name, first_notify_address_line1, second_notify_customer_code, second_notify_customer_name,
                              second_notify_address_line1, commodity_code, commodity_description, cargo_documentation_description,
                              contractual_customer_customer_code, contractual_customer_customer_name, haz, por_country_name, pod_country_name)
values ('Operator 2', 123313, 345234, 624552, 'Customer Name 2', 141123, 'Shipper Name 2', 'Bul Mil Mil 29dj', 'Bul Zor Djin 28',
        89934, 'Consignee Name 2', 'Bul Kr Aleks 39', 7183812, 'Notify Name 2', 'Bul Oslob 292', 81712, 'Second notify name 2',
        'Bul rev 14', '321412', '21WCQU 18992', 'WLE 87831 SPOPS', 321124, 'Con Cust Name 2', 'HA1', 'Serbia', 'Montenegro');

insert into screening_task (result_id, assigned_to, status, created_at, updated_at)
values (1, 'Assigned To 1', 'ACTIVE', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

insert into screening_task (result_id, assigned_to, status, created_at, updated_at)
values (2, 'Assigned To 2', 'PENDING', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);