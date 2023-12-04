package ra.rest_api_practice.mapper;

public interface GenericMapper<E,R,S> {
    //E: entity, R: Request, S: Response
    //1. Phương thức chuyển đổi từ RequestDTO --> entity
    E toEntity(R r);
    //2. Phương thức chuyển đổi từ entity --> ResponseDTO
    S toResponse(E e);
}
