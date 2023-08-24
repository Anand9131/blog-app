package com.ecommerce.demo.entites;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NonNull;
@Entity
@Data
public class Category {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(name = "category_name",nullable = false)
        @NonNull
        private String categoryName;
        @Column(name = "description" ,nullable = false)
        @NonNull
        private String description;
        @Column(name = "image_url")
        @NonNull
        private  String imageUrl;


        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public String getCategoryName() {
                return categoryName;
        }

        public void setCategoryName(String categoryName) {
                this.categoryName = categoryName;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public String getImageUrl() {
                return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
                this.imageUrl = imageUrl;
        }
}






