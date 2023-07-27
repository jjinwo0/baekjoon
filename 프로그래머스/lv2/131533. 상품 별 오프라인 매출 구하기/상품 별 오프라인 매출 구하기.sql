-- 코드를 입력하세요
SELECT p.product_code, sum(p.price*o.sales_amount) as '매출액'
from product p inner join offline_sale o on p.product_id = o.product_id
group by 1
order by 매출액 desc, p.product_code asc;