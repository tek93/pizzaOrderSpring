package com.example.microserviceproductmenagement.model.converter;

import com.example.microserviceproductmenagement.model.Cart;
import com.example.microserviceproductmenagement.model.CartDto;
import com.example.microserviceproductmenagement.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class PizzaConverter {
    @Autowired
  private   CardRepository cardRepository;

    public CartDto entityToDto(Cart cart){
        CartDto dto = new CartDto();
        dto.setId(cart.getId());
        dto.setName(cart.getPizza().getName());
        dto.setPrice(cart.getPizza().getPrice());
        dto.setQuantity(cart.getQuantity());
       dto.setUserId(cart.getUserId());
       return dto;

    }
    public List<CartDto>findforuser(Long userId){

        List<Cart> cart = cardRepository.findAllByUserId(userId);
        return cart.stream().map(x->entityToDto(x)).collect(Collectors.toList());


    }

//
//    @Component
//    public class CommentConverter {
//
//
//        public CommentDto entityToDto(Comment comment){
//            CommentDto dto = new CommentDto();
//            dto.setId(comment.getId());
//            dto.setContent(comment.getContent());
//            dto.setCreated(comment.getCreated());
//            dto.setPostId(comment.getPostId());
//            dto.setUsername(comment.getUserId().getUsername());
//            dto.setUserId(comment.getUserId().getId().toString());
//            return dto;
//
//        }
//
//        public List<CommentDto> entityToDto(List<Comment> comment){
//            return comment.stream().map(x->entityToDto(x)).collect(Collectors.toList());
//        }
////    public Comment dtoToEntity(CommentDto dto){
////        Comment st=new Comment();
////        st.setId(dto.getId());
////        st.setUserId(dto.getUserId());
////        st.setPostId(dto.getPostId());
////
////    }
//
//    }
}
