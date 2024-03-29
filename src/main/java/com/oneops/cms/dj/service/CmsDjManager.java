/*******************************************************************************
 *  
 *   Copyright 2015 Walmart, Inc.
 *  
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *  
 *       http://www.apache.org/licenses/LICENSE-2.0
 *  
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *  
 *******************************************************************************/
package com.oneops.cms.dj.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.oneops.cms.dj.domain.CmsDeployment;
import com.oneops.cms.dj.domain.CmsDpmtApproval;
import com.oneops.cms.dj.domain.CmsDpmtRecord;
import com.oneops.cms.dj.domain.CmsDpmtStateChangeEvent;
import com.oneops.cms.dj.domain.CmsRelease;
import com.oneops.cms.dj.domain.CmsRfcCI;
import com.oneops.cms.dj.domain.CmsRfcRelation;
import com.oneops.cms.dj.domain.CmsWorkOrder;

/**
 * The Interface CmsDjManager.
 */
@Transactional
public interface CmsDjManager {
	CmsRelease createRelease(CmsRelease release);
	CmsRelease updateRelease(CmsRelease release);
	CmsRelease getReleaseById(long releaseId);
	List<CmsRelease> getReleaseBy3(String nsPath, String releaseName, String releaseState);
	List<CmsRelease> getLatestRelease(String nsPath, String releaseState);
	long deleteRelease(long releaseId);
	void commitRelease(long releaseId,Boolean setDfValue, String newCiState, String userId, String desc);
	
	CmsRfcCI createRfcCI(CmsRfcCI rfcCi);
	CmsRfcCI updateRfcCI(CmsRfcCI rfcCi);	
	CmsRfcCI getRfcCIById(long rfcId);
	long rmRfcCiFromRelease(long rfcId);
	List<CmsRfcCI> getRfcCIBy3(long releaseId, Boolean isActive, Long ciId);
    List<CmsRfcCI> getClosedRfcCIByCiId(long ciId);
    CmsRfcCI getRollUpRfc(long ciId, long rfcId);

    CmsRfcRelation createRfcRelation(CmsRfcRelation rel);
	CmsRfcRelation updateRfcRelation(CmsRfcRelation rel);
	CmsRfcRelation getRfcRelationById(long rfcId);
	long rmRfcRelationFromRelease(long rfcId);
	List<CmsRfcRelation> getRfcRelationByReleaseId(long releaseId);
	List<CmsRfcRelation> getRfcRelationBy3(long releaseId,Boolean isActive,Long fromCiId, Long toCiId);

	CmsDeployment deployRelease(long releaseId);
	CmsDeployment createDeployment(CmsDeployment dpmt);
	CmsDeployment getDeployment(long dpmtId);
	CmsDeployment updateDeployment(CmsDeployment dpmt);
	CmsDpmtRecord updateDpmtRecord(CmsDpmtRecord rec);
	//List<CmsDeployment> dpmtApprove(List<CmsDpmtApproval> approvals);
	List<CmsDpmtApproval> updateApprovalList(List<CmsDpmtApproval> approvals);
	List<CmsDpmtApproval> getDeploymentApprovals(long dpmtId);
	CmsDpmtApproval getDeploymentApproval(long approvalId);

	List<CmsDeployment> findDeployment(String nsPath, String state, Boolean recursive, boolean latest);
	long countDeployments(String nsPath, String state, Boolean recursive);
	Map<String, Long> countDeploymentGroupByNsPath(String nsPath, String state);
	List<CmsDeployment> findDeploymentByReleaseId(long releaseId, String state, boolean latest);
	List<CmsDpmtRecord> getDpmtRecords(long dpmtId);
	List<CmsDpmtRecord> getDpmtRecordCis(long dpmtId);
	List<CmsDpmtRecord> getDpmtRecordCis(long dpmtId, String state, Integer execOrder);
	List<CmsDpmtRecord> getDpmtRecordRelations(long dpmtId);
	List<CmsDpmtRecord> getDeploymentRecordByCiId(long ciId, String state);
	CmsDpmtRecord getDpmtRecord(long dpmtRecordId);
	long getDeploymentRecordCount(long dpmtId, String state, Integer execOrder);
	
//	List<CmsWorkOrder> getWorkOrders(long deploymentId, String state, Integer execOrder, Integer limit);
//	List<CmsWorkOrder> getWorkOrderIds(long deploymentId, String state, Integer execOrder, Integer limit);
//	CmsWorkOrder getWorkOrder(long dpmtRecordId, String state, Integer execOrder);
	void completeWorkOrder(CmsWorkOrder wo);
	
	List<CmsDpmtStateChangeEvent> getDeploymentStateHist(long deploymentId);

}
