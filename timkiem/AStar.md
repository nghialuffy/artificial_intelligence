# A* là gì?

A* là giải thuật tìm kiếm trong đồ thị, tìm đường đi từ một đỉnh hiện tại đến đỉnh đích có sử dụng hàm để ước lượng khoảng cách hay còn gọi là hàm Heuristic.

Từ trạng thái hiện tại A\* xây dựng tất cả các đường đi có thể đi dùng hàm ước lược khoảng cách (hàm Heuristic) để đánh giá đường đi tốt nhất có thể đi. Tùy theo mỗi dạng bài khác nhau mà hàm Heuristic sẽ được đánh giá khác nhau. A* luôn tìm được đường đi ngắn nhất nếu tồn tại đường đi như thế.

A* lưu giữ một tập các đường đi qua đồ thị, từ đỉnh bắt đầu đến đỉnh kết thúc, tập các đỉnh có thể đi tiếp được lưu trong tập Open.

Thứ tự ưu tiên cho một đường đi đươc quyết định bởi hàm Heuristic được đánh giá f(x) = g(x) + h(x)

    g(x) là chi chi phí của đường đi từ điểm xuất phát cho đến thời điểm hiện tại.
    h(x) là hàm ước lượng chi phí từ đỉnh hiện tại đến đỉnh đích f(x) thường có giá trị càng thấp thì độ ưu tiên càng cao.

Thuật giải A*

    Open: tập các trạng thái đã được sinh ra nhưng chưa được xét đến.
    Close: tập các trạng thái đã được xét đến.
    Cost(p, q): là khoảng cách giữa p, q.
    g(p): khoảng cách từ trạng thái đầu đến trạng thái hiện tại p.
    h(p): giá trị được lượng giá từ trạng thái hiện tại đến trạng thái đích.
    f(p) = g(p) + h(p)
        Bước 1:
            Open: = {s}
            Close: = {}
        Bước 2: while (Open !={})
            Chọn trạng thái (đỉnh) tốt nhất p trong Open (xóa p khỏi Open).
            Nếu p là trạng thái kết thúc thì thoát.
            Chuyển p qua Close và tạo ra các trạng thái kế tiếp q sau p.
                Nếu q đã có trong Open
                    Nếu g(q) > g(p) + Cost(p, q)
                        g(q) = g(p) + Cost(p, q)
                        f(q) = g(q) + h(q)
                        prev(q) = p (đỉnh cha của q là p)
                Nếu q chưa có trong Open
                    g(q) = g(p) + cost(p, q)
                    f(q) = g(q) + h(q)
                    prev(q) = p
                    Thêm q vào Open
                Nếu q có trong Close
                    Nếu g(q) > g(p) + Cost(p, q)
                        Bỏ q khỏi Close
                        Thêm q vào Open
        Bước 3: Không tìm được. 
