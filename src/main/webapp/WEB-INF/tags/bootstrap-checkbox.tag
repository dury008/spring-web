<%@ tag language="java" pageEncoding="UTF-8" body-content="empty" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="utils"  uri="/WEB-INF/tlds/utils.tld" %>
<%@ attribute name="items" type="kr.ko.dury008.mvc.domain.BaseCodeLabelEnum[]" required="true" %>
<%@ attribute name="values" type="kr.ko.dury008.mvc.domain.BaseCodeLabelEnum[]" required="false" %>

<c:forEach var="boardType" items = "${items}" varStatus="status">
	<div class="form-check form-check-inline">
		<input class="form-check-input" 
				name="boardTypes" 
				type="checkbox" 
				${utils:isSelected(values, boardType) ?  'checked="checked"' : ''}
				value="${boardType.code()}" 
				id="board-type${status.count}">
		<label class = "form-check-label" for="board-type${status.count}">
			${boardType.label()}
		</label>
	</div>
</c:forEach>