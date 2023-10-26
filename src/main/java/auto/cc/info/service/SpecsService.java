package auto.cc.info.service;

import auto.cc.info.commands.SpecsCommand;

public interface SpecsService {
    SpecsCommand createNewSpecs(SpecsCommand specsCommand);
}
