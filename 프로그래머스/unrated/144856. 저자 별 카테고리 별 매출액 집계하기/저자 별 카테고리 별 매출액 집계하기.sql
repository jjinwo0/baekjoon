-- 코드를 입력하세요
SELECT A.AUTHOR_ID, A.AUTHOR_NAME, B.CATEGORY, SUM(S.SALES * B.PRICE) AS TOTAL_PRICE
FROM BOOK B
    JOIN BOOK_SALES S ON B.BOOK_ID = S.BOOK_ID
    JOIN AUTHOR A ON B.AUTHOR_ID = A.AUTHOR_ID
WHERE MONTH(S.SALES_DATE)='01' AND YEAR(S.SALES_DATE)='2022'
GROUP BY A.AUTHOR_NAME, B.CATEGORY
ORDER BY AUTHOR_ID ASC, B.CATEGORY DESC