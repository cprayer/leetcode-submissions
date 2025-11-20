SELECT
    t1.user_id,
    ROUND(
        AVG(CASE WHEN t1.activity_type = 'free_trial' THEN t1.activity_duration ELSE NULL END),
        2
    ) AS trial_avg_duration,
    ROUND(
        AVG(CASE WHEN t1.activity_type = 'paid' THEN t1.activity_duration ELSE NULL END),
        2
    ) AS paid_avg_duration
FROM
    UserActivity t1
WHERE
    t1.user_id IN (
        SELECT
            t2.user_id
        FROM
            UserActivity t2
        WHERE
            t2.activity_type IN ('free_trial', 'paid')
        GROUP BY
            t2.user_id
        HAVING
            COUNT(DISTINCT t2.activity_type) = 2
    )
GROUP BY
    t1.user_id
ORDER BY
    t1.user_id;
