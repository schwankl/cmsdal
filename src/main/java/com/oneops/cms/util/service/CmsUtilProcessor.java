package com.oneops.cms.util.service;

import org.apache.log4j.Logger;

import com.oneops.cms.util.dal.UtilMapper;

public class CmsUtilProcessor {
	private Logger logger = Logger.getLogger(this.getClass());
	
	private UtilMapper utilMapper;

	/**
	 * Sets the utilMapper.
	 *
	 * @param utilMapper the new utilMapper
	 */
	public void setUtilMapper(UtilMapper utilMapper) {
		this.utilMapper = utilMapper;
	}

	/**
	 * Acquires the named lock by the process
	 *
	 * @param String lockName - name of the lock
	 * @param String processId - process identifier
	 * @param int staleTimeout - time in seconds to consider the lock is old and stale
	 */
	public boolean acquireLock(String lockName, String processId, int staleTimeout) {
		boolean locked = utilMapper.acquireLock(lockName, processId, staleTimeout);
		if (locked) {
			logger.info("Lock " + lockName + " granted to " + processId);
		} else {
			logger.info("Lock " + lockName + " denied to " + processId);
		}
		return locked;
	}

	/**
	 * Refresh the named lock by the process
	 *
	 * @param String lockName - name of the lock
	 * @param String processId - process identifier
	 */
	public boolean refreshLock(String lockName, String processId) {
		boolean locked = utilMapper.acquireLock(lockName, processId, 1000000);
		if (!locked) {
			logger.info("Can not refresh the lock " + lockName + " granted to " + processId + "; other process stole it!");
		}
		return locked;
	}
	
	/**
	 * Release the named lock by the process
	 *
	 * @param String lockName - name of the lock
	 * @param String processId - process identifier
	 */
	public void releaseLock(String lockName, String processId) {
		utilMapper.releaseLock(lockName, processId);
		logger.info("Lock " + lockName + " released by " + processId);
	}
}
