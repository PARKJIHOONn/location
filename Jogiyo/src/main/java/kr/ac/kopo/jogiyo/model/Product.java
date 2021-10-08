package kr.ac.kopo.jogiyo.model;

import java.util.List;

public class Product {
   private int productId;
   private String productName;
   private int price;
   private String productInfo;
   private int storeId;
   private List<ProductImage> productImages;
   
   
   public int getProductId() {
      return productId;
   }
   public void setProductId(int productId) {
      this.productId = productId;
   }
   public String getProductName() {
      return productName;
   }
   public void setProductName(String productName) {
      this.productName = productName;
   }
   public int getPrice() {
      return price;
   }
   public void setPrice(int price) {
      this.price = price;
   }
   public String getProductInfo() {
      return productInfo;
   }
   public void setProductInfo(String productInfo) {
      this.productInfo = productInfo;
   }
   public int getStoreId() {
      return storeId;
   }
   public void setStoreId(int storeId) {
      this.storeId = storeId;
   }
   public List<ProductImage> getProductImages() {
      return productImages;
   }
   public void setProductImages(List<ProductImage> productImages) {
      this.productImages = productImages;
   }

   
   
}