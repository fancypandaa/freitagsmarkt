package auto.cc.info.service;

import auto.cc.info.dto.car.specs.SuspensionsDTO;

public interface SuspensionsService {
    SuspensionsDTO createNewSuspensionsItems(SuspensionsDTO suspensionsCommand);
}
