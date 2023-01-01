package test.dao;

import test.entity.SoftwareHardwarePlatform;

public interface SoftwareHardwarePlatformDao {
    void addSoftwareHardwarePlatform(SoftwareHardwarePlatform softwareHardwarePlatform);
    void updateSoftwareHardwarePlatform(SoftwareHardwarePlatform softwareHardwarePlatform);
    void deleteSoftwareHardwarePlatform(int software_id);
    int getSoftwareHardwarePlatformId();
    SoftwareHardwarePlatform getSoftwareHardwarePlatform(int software_id);
}
