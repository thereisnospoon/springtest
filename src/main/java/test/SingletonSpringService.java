package test;

import org.springframework.stereotype.Service;

import javax.inject.Inject;
import javax.inject.Provider;

@Service
public class SingletonSpringService {

    @Inject
    private Provider<PrototypeBean> prototypeBeanProvider;

    public PrototypeBean getPrototypeBean() {
        return prototypeBeanProvider.get();
    }
}
