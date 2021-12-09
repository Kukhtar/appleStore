package ua.ipz4.aplleStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.ipz4.aplleStore.model.UserModel;

public interface UserRepo extends JpaRepository<UserModel, Long> {
    UserModel findByLogin(String login);
}
