package com.example.encryption.controller;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.encryption.entity.Req;
import com.example.encryption.service.EncryptionService;

@RestController
public class EncryptionController {

	@Autowired
	EncryptionService eService;
	
	@GetMapping("/get")
	String encrypt(@PathParam("name") String name) throws Exception {
		return eService.encrypt(name);
	}
	
	@PostMapping("/decrypt")
	String decrypt(@RequestBody Req req) throws NoSuchAlgorithmException, InvalidKeySpecException, GeneralSecurityException {
		return eService.decrypt(req.getEcryptText());
	}
	
	
	
	@GetMapping("/demo")
	public String[] demo() {
		return new String [] {
				"first",
				"second",
				"third"
		};
	}
}
