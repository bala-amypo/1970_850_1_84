package com.example.demo.service;

import com.example.demo.model.VerificationLog;
import com.example.demo.repository.VerificationLogRepository;
import org.springframework.stereotype.Service;

@Service
public class VerificationLogServiceImpl implements VerificationLogService {

    private final VerificationLogRepository verificationLogRepository;

    public VerificationLogServiceImpl(VerificationLogRepository verificationLogRepository) {
        this.verificationLogRepository = verificationLogRepository;
    }

    @Override
    public VerificationLog saveLog(VerificationLog log) {
        return verificationLogRepository.save(log);
    }
}
