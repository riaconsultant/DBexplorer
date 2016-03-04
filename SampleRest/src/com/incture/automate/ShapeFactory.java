package com.incture.automate;

public class ShapeFactory {

	public static void getShape(RequestMainDto requestMainDto) {
		Shape shape = null;
		if (requestMainDto != null && requestMainDto.getRequestEntity() != null
				&& requestMainDto.getRequestEntity().size() > 0) {
			System.out.println("inside getshape()--- Entity");
			shape = new DOShape();
			for (ParentDTO requestEntity : requestMainDto.getRequestEntity()) {
				System.out.println(((RequestEntity) requestEntity)
						.getEntityName());
				shape.draw(requestEntity);
			}
		}
		System.out.println(requestMainDto.getRequestDto().get(0).getDtoName());
		if (requestMainDto != null && requestMainDto.getRequestDto() != null
				&& requestMainDto.getRequestDto().size() > 0) {
			System.out.println("inside getshape()--- DTO");
			shape = new DTOShape();
			for (RequestDto requestDto : requestMainDto.getRequestDto()) {
				System.out.println(((RequestDto) requestDto).getDtoName());
				shape.draw(requestDto);
			}
		}
		if (requestMainDto != null && requestMainDto.getRequestBean() != null
				&& requestMainDto.getRequestBean().size() > 0) {
			System.out.println("inside getshape()--- BEAN");
			
			
			for (ParentDTO requestDaoBean : requestMainDto.getRequestBean()) {
				shape = new DAOShape();
				shape.draw(requestDaoBean);
				shape = new BeanShape();
				shape.draw(requestDaoBean);
			}
		}
	}
}
