
function apply(gno,gname,sno){
	 $.ajax({
	        url: "servlet/serInsertApply?action=apply&GNo="+gno+"&Gname="+gname,
	        type: "GET",
	        async: false,
	        dataType: "text",
	        cache: false,
	        success: function (text) {
	            if (text === "success") {
					alert("提交加入申请成功");
	            } 
	            else if(text=="applied") {
	            	alert("你已申请过该团队");
				}
	            else {
	            	alert("申请失败");
	            }
	        }
  })
}

function agree(applicant_sno){
	
	 $.ajax({
	        url: "servlet/serUpdateApply?action=agree&SNo="+applicant_sno,
	        type: "GET",
	        async: false,
	        dataType: "text",
	        cache: false,
	        success: function (text) {
	            if (text === "success") {
					alert("已同意");
	            } 
	            else if(text=="ismember") {
	            	alert("该同学已加入别的组");
				}
	            else {
	            	alert("操作失败")
	            }
	        }
 })
}

function refuse(applicant_sno){
	 $.ajax({
	        url: "servlet/serUpdateApply?action=refuse&SNo="+applicant_sno,
	        type: "GET",
	        async: false,
	        dataType: "text",
	        cache: false,
	        success: function (text) {
	            if (text === "success") {
					alert("已拒绝");
					$('#msg').load();
	            } 
	            else if(text=="ismember") {
	            	alert("该同学已加入别的组");
				}
	            else {
	            	alert("操作失败")
	            }
	        }
})
}