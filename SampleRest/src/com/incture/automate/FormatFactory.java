package com.incture.automate;

public class FormatFactory {
	public static RequestProject rProject;
	public static void getFormat(ClientRequestDto requestMainDto) {
		Format shape = null;
		
		if (requestMainDto != null && requestMainDto.getReqProject() !=null) {
			System.out.println("***"+requestMainDto.getReqProject().getpName());
			
			rProject = requestMainDto.getReqProject();
		
		}
		
		if (requestMainDto != null && requestMainDto.getRequestEntity() != null
				&& requestMainDto.getRequestEntity().size() > 0) {
			System.out.println("inside getshape()--- Entity");
			shape = new DOFormat();
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
			shape = new DTOFormat();
			for (RequestDto requestDto : requestMainDto.getRequestDto()) {
				System.out.println(((RequestDto) requestDto).getDtoName());
				shape.draw(requestDto);
			}
		}
		if (requestMainDto != null && requestMainDto.getRequestBean() != null
				&& requestMainDto.getRequestBean().size() > 0) {
			System.out.println("inside getshape()--- BEAN");
			
			
			for (ParentDTO requestDaoBean : requestMainDto.getRequestBean()) {
				shape = new DAOFormat();
				shape.draw(requestDaoBean);
				shape = new BeanFormat();
				shape.draw(requestDaoBean);
			}
		}
	}
}
