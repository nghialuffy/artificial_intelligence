# Thuật giải

Một số quy ước:

    Open: là tập hợp các đỉnh chờ được xét ở bước tiếp theo theo ngăn xếp (ngăn xếp: dãy các phần tử mà khi thêm phần tử vào sẽ thêm vào đầu dãy, còn khi lấy phần tử ra sẽ lấy ở phần tử đứng đầu dãy).
    Close: là tập hợp các đỉnh đã xét, đã duyệt qua.
    s: là đỉnh xuất phát, đỉnh gốc ban đầu trong quá trình tìm kiếm.
    g: đỉnh đích cần tìm.
    p: đỉnh đang xét, đang duyệt.

Trình bày thuật giải:

    Tập Open chứa đỉnh gốc s chờ được xét.
    Kiểm tra tập Open có rỗng không.
        Nếu tập Open không rỗng, lấy một đỉnh ra khỏi tập Open làm đỉnh đang xét p.
            Nếu p là đỉnh g cần tìm, kết thúc tìm kiếm.
        Nếu tập Open rỗng, tiến đến bước 4.
    Đưa đỉnh p vào tập Close, sau đó xác định các đỉnh kề với đỉnh p vừa xét.
        Nếu các đỉnh kề không thuộc tập Close, đưa chúng vào đầu tập Open. Quay lại bước 2.
    Kết luận không tìm ra đỉnh đích cần tìm.
