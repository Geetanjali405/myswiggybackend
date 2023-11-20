package com.example.myswiggy.response;

import com.example.myswiggy.entity.User;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponse extends UserProfileResponse{
private User users;
}
