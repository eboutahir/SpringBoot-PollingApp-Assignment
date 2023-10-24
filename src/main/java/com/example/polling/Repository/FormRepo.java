package com.example.polling.Repository;

import com.example.polling.domains.Form;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormRepo extends JpaRepository<Form,Long> {

    Form getFormById(Long id);


}
