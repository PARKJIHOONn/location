const state = {
			page: 1,
			perPage: 10,
			search: 0,
			keyword: "", 
			order: "",
			orderMode: 0,
	};
	
	const header = [];
	
	function makeItem(data_){
		const tr = $("<tr>");
		
		tr.attr("data-code", data_[key]);   //data_.code -> data_["code"] 써도됨    const key = "code"; -> data_[key] 나중에 " "안에 들어있는 변수만 변경하면됨
		const input = $("<input>");
		input.attr("type", "checkbox");
		input.addClass("form-check-input item-check");
		input.val(data_[key]);
		tr.append( $("<td>").append(input) );
		
		header.forEach(item => tr.append( $("<td>").text(data_[item]).addClass(item)));
		
		/*tr.append( $("<td>").text(data_.code).addClass("code"));
		tr.append( $("<td>").text(data_.title).addClass("title"));
		tr.append( $("<td>").text(data_.startDate).addClass("startDate"));
		tr.append( $("<td>").text(data_.endDate).addClass("endDate"));*/

		const td = $("<td>");
		td.append($("<button>").addClass("delete btn btn-sm btn-danger mx-1").append($("<i>").addClass("bi bi-trash")));
		td.append($("<button>").addClass("update btn btn-sm btn-warning mx-1").append($("<i>").addClass("bi bi-check2-square")));

		tr.append(td);

		return tr;
	}
	
	function movePage(page) {
		state.page = page;
		
		$.ajax( url, {
			method: "GET",
			contentType: "application/json",
			dataType: "json",
			data: state, //JSON.stringify(state),
			success: (data_, status_) => {
				const list = data_.list;
				
				state.total = data_.pager.total;
				$("#total").text(state.total);
				
				$("th i").remove();
				if(data_.pager.orderMode !== 0 ) {
					const th = $(`th[data-order='${data_.pager.order}']`);
					const icon = $("<i>");
					
					if(data_.pager.orderMode == 1) 
						icon.addClass("bi bi-caret-up");
					else
						icon.addClass("bi bi-caret-down");
					
					th.append(icon);
				}

				const tbody = $("<tbody>");
					for(let i=0; i < list.length; i++) {
						
						const tr = makeItem(list[i]);
						
						tbody.append(tr);	
				}

				$("tbody").remove();
				$("table").append(tbody);
				
				$("#page-prev").data("page", data_.pager.prev);
				$("#page-next").data("page", data_.pager.next);
				$("#page-last").data("page", data_.pager.last);
				
				$(".page-list").remove();
				
				const pageList = data_.pager.list;
				for(let i=0; i<pageList.length; i++) {
					/* <div class="page-item"><p class="page-link">1</p></div> */
					const div = $("<div>").addClass("page-item");
					
					div.addClass("page-list");
					
					if(data_.pager.page == pageList[i])
						div.addClass("active")
						
					const p = $("<p>");
					p.addClass("page-link");
					p.text(pageList[i]);
					p.attr("data-page", pageList[i]);
					// div, p 태그 만드는 변수
					
					div.append(p);
					
					$("#page-next").parent().before(div);
					
				}

			},
				error: (xhr, status_, error_) => {
					console.log(error_);
					
				}
				});
	}
	
 	$(function() { // window onload가 실행될때 만들어지는 부분
 		$("th.order").each((index, item) => {
			header.push($(item).data("name"));
		});
			
	
 		$(".order").click(function() {
		if(	state.order ==  $(this).data("order"))
			state.orderMode = ++state.orderMode % 3;
 		else {
			state.order = $(this).data("order");
			state.orderMode = 1;
			}	
 			movePage(1);
 		});
 		
 		$("#delete_list").click(function() {
 			const list = $(".item-check:checked").get();
 			
 			
 			const selected = list.map(item => item.value);

 			$.ajax( url, {
 				method: "DELETE",
 				contentType: "application/json",
 				dataType: "json",
 				data: JSON.stringify(selected),
 				success: (data_, status_) => {
 					movePage(state.page);
 					
 					},
					error: (xhr, status, error) => { 
					alert("오류 발생: " + xhr.statusText);
					
				}
				
		
 				});
 			});
 	
 		
 		$("thead input[type='checkbox']").on("change", function() {
 			const checked =  $(this).prop("checked"); 
 			
 				$(".item-check").prop("checked", checked);
 		});
 		
 		$("#search_button").click(function() {
 			const search = $("#search").val();
 			
 			if(search == 0) {
 				alert('검색항목을 먼저 선택하여 주세요');
 				return;
 			}
 			
 			
 			const keyword = $("#keyword").val();
 			
 			if(keyword == "") {
 				alert("검색어를 입력하여 주세요");
 				$("#keyword").focus();
 				return;
 			}
 			
 			state.search = search;
 			state.keyword = keyword;
 			
 			movePage(1);
 			
 		});
 	
 		
 		$("#perPage").on("change", function() {
 			const perPage = $(this).val();
 			
 			state.perPage = perPage;
 			movePage(1);  //사용자가 혼란스러울 수 있으니 첫페이지로 가도록 만들음 		
 		});
 	
 	
 		
		$(".pagination").on("click", ".page-link", function() {
          	const page = $(this).data("page");
          	movePage(page);
       	});


		
		$("#updateModal .update").click(function() {
			let item_ = {};
			
			header.forEach(value => item_[value] = $(`#updateModal .${value}`).val());

			$.ajax(url, {
				method: "PUT",
				data: JSON.stringify(item_),
				contentType: "application/json",
				dataType: "json",
				success: function(data_) {
					header.forEach(item => $(`tr[data-code='${data_[key]}'] .${item}`).text(data_[item]));
				}
			});

			$("#updateModal").modal("hide");
			// updateModal 닫아줌
		});


		$("table").on("click", ".update", function() {
	
			header.forEach(item => {
				const value = $(this).parent().siblings(`.${item}`).text();
			$(`#updateModal .${item}`).val(value);
			});

			$("#updateModal").modal("show");
			// 모달 띄우는거까진 성공함


		});

		$('#addModal .add').click(function() {
			// ↓ 객체에 넣어서 값을 읽을 것 
			const item_ = {};

			header.forEach(value => {
				if(value != key) {
					item_[value] = $(`#addModal .${value}`).val();
					$(`#addModal .${value}`).val("");
				}
			});
			
			$.ajax(url, {
				method: "POST",
				data: JSON.stringify(item_),
				contentType: "application/json",
				dataType: "json",
				success: function(data_) {
					const tr = makeItem(data_);

					$("tbody").append(tr);
					
					$("#total").text(++state.total);
					
				}
				
			});

			$("#addModal").modal("hide");
		});

		$("table").on("click", "button.delete",function() {
			// 부모 태그에 on메소드를 사용에 click걸어줌
			const code_ = $(this).parent().parent().data("code") ; //delete(button)의 부모 td의 부모 tr의 code
			
			$.ajax(url +"/" + code_, {
				method: "DELETE",
				contentType: "application/json",
				dataType: "json",
				success: (data_, status_) => {
					
					if(code_ === data) {
						$("tr[data-code='" + code_ + "']").remove();
						$("#total").text(--state.total);
					}
				},
				error: (xhr, status, error) => {
				alert("오류 발생: " + xhr.statusText);
						
					
				}
			});
		});	
		
		movePage(1);  //movePage를 안쓰면 처음 목록이 뜨지않아 꼭 써줘야함 이게 없어서 첫화면이 등록한 목록이 없다고 뜸
	});/**
 * 
 */