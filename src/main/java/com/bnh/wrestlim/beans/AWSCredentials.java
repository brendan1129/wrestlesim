package com.bnh.wrestlim.beans;


import com.amazonaws.auth.BasicAWSCredentials;

public class AWSCredentials {
    public static final BasicAWSCredentials awsCredentials = new BasicAWSCredentials(
            "accessKey",
            "secretKey"
    );
}

