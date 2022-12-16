DECLARE
    cnt NUMBER := 0;
BEGIN
    LOOP
        EXIT WHEN cnt > 199;
        cnt := cnt + 1;
        INSERT INTO content_table (
            content_idx,
            content_subject,
            content_text,
            content_file,
            content_writer_idx,
            content_board_idx,
            content_date
        ) VALUES (
            content_seq.NEXTVAL,
            '�׽�Ʈ ���� ' || to_char(cnt),
            '�׽�Ʈ ���� ' || to_char(cnt),
            NULL,
            1,
            3,
            sysdate
        );

    END LOOP;
END;

