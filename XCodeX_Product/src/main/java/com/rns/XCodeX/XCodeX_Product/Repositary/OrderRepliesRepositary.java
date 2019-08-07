package com.rns.XCodeX.XCodeX_Product.Repositary;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rns.XCodeX.XCodeX_Product.model.OrderReplies;
@Repository
public interface OrderRepliesRepositary extends CrudRepository<OrderReplies, Long> {

}
