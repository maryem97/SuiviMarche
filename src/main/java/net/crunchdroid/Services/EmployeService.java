package net.crunchdroid.Services;

import net.crunchdroid.Repositories.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeService {
    @Autowired
    EmployeRepository employeRepository;
}
