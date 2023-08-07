-- 코드를 입력하세요
SELECT m.member_name, r.review_text, date_format(r.review_date, "%Y-%m-%d") as review_date
FROM member_profile as m
JOIN rest_review as r
ON m.member_id = r.member_id
WHERE m.member_id = (
  SELECT MEMBER_ID
  FROM REST_REVIEW
  GROUP BY MEMBER_ID
  ORDER BY COUNT(*) DESC LIMIT 1
)
ORDER BY review_date asc, review_text asc;